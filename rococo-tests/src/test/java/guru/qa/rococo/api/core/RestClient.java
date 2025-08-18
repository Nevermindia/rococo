package guru.qa.rococo.api.core;


import guru.qa.rococo.config.Config;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.ArrayUtils;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.CookieManager;
import java.net.CookiePolicy;

public abstract class RestClient {
    private final OkHttpClient okHttpClient;
    protected static final Config CFG = Config.getInstance();
    protected final Retrofit retrofit;

    public RestClient(String baseUrl,
                      HttpLoggingInterceptor.Level httpLogLevel) {
        this(baseUrl, false, JacksonConverterFactory.create(), httpLogLevel);
    }

    public RestClient(String baseUrl) {
        this(baseUrl, false, JacksonConverterFactory.create(), HttpLoggingInterceptor.Level.BODY);
    }

    public RestClient(String baseUrl, boolean followRedirect) {
        this(baseUrl, followRedirect, JacksonConverterFactory.create(), HttpLoggingInterceptor.Level.BODY);
    }

    public RestClient(String baseUrl, Converter.Factory factory) {
        this(baseUrl, false, JacksonConverterFactory.create(), HttpLoggingInterceptor.Level.BODY);
    }

    public RestClient(String baseUrl, boolean followRedirect, @Nullable Interceptor... interceptors) {
        this(baseUrl, followRedirect, JacksonConverterFactory.create(), HttpLoggingInterceptor.Level.HEADERS, interceptors);
    }

    public RestClient(String baseUrl,
                      boolean followRedirect,
                      Converter.Factory factory,
                      HttpLoggingInterceptor.Level level,
                      Interceptor... interceptors
    ) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .followRedirects(followRedirect);

        if (ArrayUtils.isNotEmpty(interceptors)) {
            for (Interceptor interceptor : interceptors) {
                builder.addNetworkInterceptor(interceptor);
            }
        }
        builder.addNetworkInterceptor(new AllureOkHttp3()
                .setRequestTemplate("my-http-request.ftl")
                .setResponseTemplate("my-http-response.ftl"));
        builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(level));
        builder.cookieJar(
                new JavaNetCookieJar(
                        new CookieManager(
                                ThreadSafeCookieStore.INSTANCE,
                                CookiePolicy.ACCEPT_ALL
                        )
                )
        );
        this.okHttpClient = builder.build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(factory)
                .build();
    }

    @Nonnull
    public <T> T create(final Class<T> service) {
        return this.retrofit.create(service);
    }

}
