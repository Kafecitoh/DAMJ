package CONTORNOS.CONVERTIR;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


        @Test
        void testAgeNegativeThrowsException() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                AgeClassifier.classify(-5);
            });
            assertEquals("Idade non válida", exception.getMessage());
        }

        @Test
        void testAgeTooHighThrowsException() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                AgeClassifier.classify(121);
            });
            assertEquals("Idade non válida", exception.getMessage());
        }

        @Test
        void testInfantilCategory() {
            assertEquals("Infantil", AgeClassifier.classify(0));
            assertEquals("Infantil", AgeClassifier.classify(5));
            assertEquals("Infantil", AgeClassifier.classify(12));
        }

        @Test
        void testAdolescenteCategory() {
            assertEquals("Adolescente", AgeClassifier.classify(13));
            assertEquals("Adolescente", AgeClassifier.classify(15));
            assertEquals("Adolescente", AgeClassifier.classify(17));
        }

        @Test
        void testAdultoCategory() {
            assertEquals("Adulto", AgeClassifier.classify(18));
            assertEquals("Adulto", AgeClassifier.classify(30));
            assertEquals("Adulto", AgeClassifier.classify(64));
        }

        @Test
        void testSeniorCategory() {
            assertEquals("Senior", AgeClassifier.classify(65));
            assertEquals("Senior", AgeClassifier.classify(90));
            assertEquals("Senior", AgeClassifier.classify(120));
        }

