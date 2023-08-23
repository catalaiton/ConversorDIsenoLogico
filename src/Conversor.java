import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número: ");
        String numero = scanner.nextLine();

        System.out.print("Ingresa la base actual (entre 2 y 512): ");
        int baseActual = scanner.nextInt();

        if (baseActual < 2 || baseActual > 512) {
            System.out.println("La base debe estar entre 2 y 512.");
            return;
        }

        System.out.print("Ingresa la nueva base (entre 2 y 512): ");
        int nuevaBase = scanner.nextInt();

        if (nuevaBase < 2 || nuevaBase > 512) {
            System.out.println("La nueva base debe estar entre 2 y 512.");
            return;
        }

        // Definir los caracteres válidos para bases hasta 290
        String caracteresBaseActual = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワ'" +
                "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ!" +
                "¡#%&*∙\"'′″„¨`´,./:;?¿@~-−_¯¦|‹›«∀∂∃∇∈∉$¸»ªâÂäÄÃãåÅæÆÇçÐðèÈéÉêÊëËƒìÌíÍîÎïÏⁿòÒóÓôÔöÖÕõØøŒœßÞþùÙúÚûÛüÜÿ™()[]{}+-×÷^=≠<>±≈≤≥₀¹²³⁴⁵⁶⁷⁸⁹‰¼½¾∞═│║┌╒╓╗┐╕╖╗└╘╙╚┘╛╜╝├╞╟╠┤╡╢╣┬╤╥╦┴╧╨╩┼╪╫╬§©©¬®°µ¶·♠♣♥♦†‡•αβΓγΓδΔεζηΘθικΛλμνξΞπΠρΣσΣσςτυΦφχψΩωℵ⌂⌐⌠⌡◊↑→⇒↓←↔⇔─∏∑√∝∧∨∩∪∫∫∴≡⊂⊃⊆⊇БВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯбвгдежзийклмнопрстуфхцчшщъыьэюяαβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσςΤτΥυΦφΧχΨψΩω©®™€£$¥¢₹₽";

        String caracteresNuevaBase = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワ'" +
                "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ!" +
                "¡#%&*∙\"'′″„¨`´,./:;?¿@~-−_¯¦|‹›«∀∂∃∇∈∉$¸»ªâÂäÄÃãåÅæÆÇçÐðèÈéÉêÊëËƒìÌíÍîÎïÏⁿòÒóÓôÔöÖÕõØøŒœßÞþùÙúÚûÛüÜÿ™()[]{}+-×÷^=≠<>±≈≤≥₀¹²³⁴⁵⁶⁷⁸⁹‰¼½¾∞═│║┌╒╓╗┐╕╖╗└╘╙╚┘╛╜╝├╞╟╠┤╡╢╣┬╤╥╦┴╧╨╩┼╪╫╬§©©¬®°µ¶·♠♣♥♦†‡•αβΓγΓδΔεζηΘθικΛλμνξΞπΠρΣσΣσςτυΦφχψΩωℵ⌂⌐⌠⌡◊↑→⇒↓←↔⇔─∏∑√∝∧∨∩∪∫∫∴≡⊂⊃⊆⊇БВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯбвгдежзийклмнопрстуфхцчшщъыьэюяαβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσσςτυΦφΧχΨψΩω©®™€£$¥¢₹₽";

        // Convertir a decimal
        int decimalValue = customParseInt(numero, caracteresBaseActual, baseActual);

        // Convertir a la nueva base
        String nuevoNumero = customToString(decimalValue, caracteresNuevaBase, nuevaBase);

        // Convertir ambos números a base 10 para verificar
        int originalDecimal = customParseInt(numero, caracteresBaseActual, baseActual);
        int convertedDecimal = customParseInt(nuevoNumero, caracteresNuevaBase, nuevaBase);

        System.out.println("El número " + numero + " en base " + baseActual +
                " es equivalente a " + nuevoNumero + " en base " + nuevaBase);

        System.out.println("Verificación:");
        System.out.println("Número original en base 10: " + originalDecimal);
        System.out.println("Número convertido en base 10: " + convertedDecimal);
    }

    // Implementación de parseInt para bases personalizadas
    private static int customParseInt(String s, String validChars, int radix) {
        int base = validChars.length();
        int result = 0;
        int power = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char digitChar = s.charAt(i);
            int digitValue = validChars.indexOf(digitChar);
            
            if (digitValue == -1 || digitValue >= radix) {
                throw new IllegalArgumentException("Carácter inválido en el número.");
            }

            result += digitValue * power;
            power *= radix;
        }

        return result;
    }

    // Implementación de toString para bases personalizadas
    private static String customToString(int value, String validChars, int newBase) {
        int base = validChars.length();
        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            int digit = value % newBase;
            sb.insert(0, validChars.charAt(digit));
            value /= newBase;
        }

        return sb.toString();
    }
}
