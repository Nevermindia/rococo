package guru.qa.rococo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Countries {

    RUSSIA("Россия" );

    @Getter
    @Setter
    String name;

}
