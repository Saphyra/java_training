package com.github.saphyra;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true, exclude = "asd")
@EqualsAndHashCode
@NoArgsConstructor
public class Valami {
    private String ertek;
    private Boolean asd;

    @Builder
    public Valami(String ertek) {
        this.ertek = ertek;
    }
}
