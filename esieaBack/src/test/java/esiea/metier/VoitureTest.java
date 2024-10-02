package esiea.metier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import esiea.metier.Voiture.Carburant;

import static org.junit.jupiter.api.Assertions.*;


    public class VoitureTest {
        private Voiture voiture;
        String[] strings = { "marque", "modele", "finition" };
        String[] entiers = { "id", "annee", "km", "prix" };

        @BeforeEach
        public void setUp() {
            voiture = new Voiture();
            voiture.setId(1);
            voiture.setMarque("Tesla");
            voiture.setModele("Cybertruck");
            voiture.setFinition("None");
            voiture.setCarburant(Carburant.HYBRIDE);
            voiture.setKm(500);
            voiture.setAnnee(2024);
            voiture.setPrix(150000);
        }

        // voiture.check()
        @Test
        public void testCheckValidVoiture() {
            assertTrue(voiture.check(), "voiture should be valide");
        }

        @Test
        public void testCheckIdNegative() {
            voiture.setId(-1);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.id < 0");
        }

        @Test
        public void testCheckMarqueNull() {
            voiture.setMarque(null);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.marque = null");
        }

        @Test
        public void testCheckMarqueEmpty() {
            voiture.setMarque("");
            assertFalse(voiture.check(), "voiture should not be valide if voiture.marque is empty");
        }

        @Test
        public void testCheckModeleNull() {
            voiture.setModele(null);
            assertFalse(voiture.check(), "voiture should not be valid if voiture.modele = null ");
        }

        @Test
        public void testCheckModeleEmpty() {
            voiture.setModele("");
            assertFalse(voiture.check(), "voiture should not be valid if voiture.modele is empty");
        }

        @Test
        public void testFinitionNull() {
            voiture.setFinition(null);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.finition is null");
        }

        @Test
        public void testCheckFinitionEmpty() {
            voiture.setFinition("");
            assertFalse(voiture.check(), "voiture should not be valide if voiture.finition is empty");
        }

        @Test
        public void TestCheckCaarburantNull() {
            voiture.setCarburant(null);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.carburant is empty");
        }

        @Test
        public void testCheckKmNegativ() {
            voiture.setKm(-1);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.km is < 0");
        }

        @Test
        public void testCheckYearInf1900() {
            voiture.setAnnee(1800);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.annee < 1900");
        }

        @Test
        public void testCheckYearSupTodayYear() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            voiture.setAnnee(calendar.get(Calendar.YEAR) + 10);
            assertFalse(voiture.check(), String.format("voiture should not be valide if voiture.annee > today's year (%d)",
                    calendar.get(Calendar.YEAR)));
        }

        @Test
        public void testCheckPrixNegative() {
            voiture.setPrix(-10);
            assertFalse(voiture.check(), "voiture should not be valide if voiture.prix < 0");

        }

        // voiture.getTypeDonnee()
        @Test
        public void testGetTypeDonneeNull() {
            assertEquals("", voiture.getTypeDonnee(null));
        }

        @Test
        void testGetTypeDonneeString() {
            for (int i = 0; i < strings.length; i++) {
                assertEquals("string", voiture.getTypeDonnee(strings[i]));
            }
        }

        @Test
        void testGetTypeDonneeInteger() {
            for (int i = 0; i < entiers.length; i++) {
                assertEquals("entier", voiture.getTypeDonnee(entiers[i]));
            }
        }

        // voiture.toString()
        @Test
        public void testToString() {
            String expected = "{\"id\":1,\"marque\":\"Tesla\",\"modele\":\"Cybertruck\",\"finition\":\"None\",\"carburant\":\"HYBRIDE\",\"km\":500,\"annee\":2024,\"prix\":150000}";
            assertEquals(expected, voiture.toString(), String.format("toString should print: %s", expected));
        }

        // tester le catch dans voiture.toString()

        // carburant.toSring()
        @Test
        public void testToStringEssence() {
            assertEquals("E", Carburant.ESSENCE.toString(), "ESSENCE should return 'E'");
        }

        @Test
        public void testToStringDiesel() {
            assertEquals("D", Carburant.DIESEL.toString(), "DIESEL should return 'D'");
        }

        @Test
        public void testToStringHybride() {
            assertEquals("H", Carburant.HYBRIDE.toString(), "HYBRIDE should return 'H'");
        }

        @Test
        public void testToStringElectrique() {
            assertEquals("W", Carburant.ELECTRIQUE.toString(), "ELECTRIQUE should return 'W'");
        }

        // carburant.getChar()
        @Test
        public void testGetCharE() {
            assertEquals('E', Carburant.ESSENCE.getChar(), "ESSENCE should return 'E'");
        }

        @Test
        public void testGetCharD() {
            assertEquals('D', Carburant.DIESEL.getChar(), "ESSENCE should return 'D'");
        }

        @Test
        public void testGetCharH() {
            assertEquals('H', Carburant.HYBRIDE.getChar(), "ESSENCE should return 'H'");
        }

        @Test
        public void testGetCharW() {
            assertEquals('W', Carburant.ELECTRIQUE.getChar(), "ELECTRIQUE should return 'W'");
        }

        // carburant.get()
        @Test
        public void testGetEssence() {
            assertEquals(Carburant.ESSENCE, Carburant.get("E"), "get('E') should return ESSENCE");
        }

        @Test
        public void testGetDiesel() {
            assertEquals(Carburant.DIESEL, Carburant.get("D"), "get('D') should return DIESEL");
        }

        @Test
        public void testGetHybride() {
            assertEquals(Carburant.HYBRIDE, Carburant.get("H"), "get('H') should return HYBRIDE");
        }

        @Test
        public void testGetElectrique() {
            assertEquals(Carburant.ELECTRIQUE, Carburant.get("W"), "get('W') should return ELECTRIQUE");
        }

        @Test
        public void testGetInvalidInput() {
            assertNull(Carburant.get("X"), "get('X') should return null for invalid input");
            assertNull(Carburant.get(""), "get('') should return null for empty input");
            assertNull(Carburant.get(null), "get(null) should return null for null input");
        }
    }