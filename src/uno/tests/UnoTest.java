package uno.tests;

import uno.Uno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnoTest {
    Uno uno;
    @BeforeEach
    void setUp() {
       uno = new Uno();
    }

    @Test
    void creerLesJoueurs() {
        uno.creerLesJoueurs(5);

        for(int i = 0 ; i < 5 ; ++i){
            System.out.println(uno.getPlayers()[i].toString());
        }
    }
}