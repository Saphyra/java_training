package com.github.saphyra.jarmu;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DomperTest {
    private static final int KAPACITAS = 100;
    private static final int SEBESSEG = 90;

    private Domper underTest = new Domper(KAPACITAS, SEBESSEG);

    @Test
    public void motorBeindit_shouldSetJarAMotorTrue() {
        //GIVEN

        //WHEN
        underTest.motorBeindit();

        //THEN
        if (!underTest.isJarAMotor()) {
            throw new AssertionError("A jarAMotor nem lehet false");
        }
    }

    @Test
    public void motorLeallit_shouldSetJarAMotorFalse() {
        //GIVEN
        underTest.motorBeindit();
        //WHEN
        underTest.motorLeallit();
        //THEN
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void platoKinyit_shouldThrowException_whenSebessegIsNotZero() {
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        underTest.platoKinyit();
        //THEN
        assertThat(underTest.isPlatoNyitva()).isFalse();
    }

    @Test
    public void elindul_shouldThrowException_whenSebessegIsNotZero() throws NemJarAMotorException {
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        try {
            underTest.elindul(32);
        } catch (IllegalStateException e) {
            //THEN
            assertThat(underTest.getSebesseg()).isEqualTo(1);
            return;
        }

        fail("Excpected IllegalStateException was not thrown");
    }

    @Test
    public void elindul_shouldThrowException_whenNemJarAMotor() {
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(32));

        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }
}