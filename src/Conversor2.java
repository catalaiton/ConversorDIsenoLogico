import java.util.Scanner;

public class Conversor2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número: ");
        String numero = scanner.nextLine();

        System.out.print("Ingresa la base actual (entre 2 y 1024): ");
        int baseActual = scanner.nextInt();

        if (baseActual < 2 || baseActual > 1024) {
            System.out.println("La base debe estar entre 2 y 1024.");
            return;
        }

        System.out.print("Ingresa la nueva base (entre 2 y 1024): ");
        int nuevaBase = scanner.nextInt();

        if (nuevaBase < 2 || nuevaBase > 1024) {
            System.out.println("La nueva base debe estar entre 2 y 1024.");
            return;
        }

        // Definir los caracteres válidos para bases hasta 512
        String caracteresBaseActual = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワ'" +
                "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ!" +
                "¡#%&*∙\"'′″„¨`´,./:;?¿@~-−_¯¦|‹›«∀∂∃∇∈∉$¸»ªâÂäÄÃãåÅæÆÇçÐðèÈéÉêÊëËƒìÌíÍîÎïÏⁿòÒóÓôÔöÖÕõØøŒœßÞþùÙúÚûÛüÜÿ™()[]{}+-×÷^=≠<>±≈≤≥₀¹²³⁴⁵⁶⁷⁸⁹‰¼½¾∞═│║┌╒╓╗┐╕╖╗└╘╙╚┘╛╜╝├╞╟╠┤╡╢╣┬╤╥╦┴╧╨╩┼╪╫╬§©©¬®°µ¶·♠♣♥♦†‡•αβΓγΓδΔεζηΘθικΛλμνξΞπΠρΣσΣσςτυΦφχψΩωℵ⌂⌐⌠⌡◊↑→⇒↓←↔⇔─∏∑√∝∧∨∩∪∫∫∴≡⊂⊃⊆⊇БВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯбвгдежзийклмнопрстуфхцчшщъыьэюяαβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσσςτυΦφΧχΨψΩω©®™€£$¥¢₹₽"+
                "ハ÷Î¼√©—ôˆ§β«¯Γσ√°₹ãτ¬Â√°Ø†≤Σ−Î°ι¨γ¯λçΦΛγφÂ€âμ■вÎжêζÏÎΣ−βθαªГ¬ΛεâÎГπⁿâμ½Þλφô−В‹ÂÐφ§‚¦òτêΓτυВ¹Θ◊ДÐΔ¦±τθ■π§òÎσгΛ±ÎΘφ¤ëθ§ЙºиâΩ¦φ−„Θ‡½αôфр¦Δ≠£ÑÜä√¸öⁿâ◊âΓΘμ◊ô„¯≠ÏΦπτ†αΦµΣΦΓªгπ°⌠¤ïВ±πθμê¸»ãΓτâ■ηâá»êÎΔηαÏâµεüёθâτæâê•¼¦Î±λ¥■§ΣêÎΦγï±¬¯ï−ΛÎΛ−τÎτ†Ω´Î­•φτβΓΓ¬‰ΩÎΛκΩÎ‰¦γΘΩΣΣòεΩ­τ¯ⁿτ¢η╔«³ΩÎαΦπⁿòΘ§îρεÎΘΛÎ§ΛΛΩτ⌡Θ▒½¤ατλττ⌠ΩÏ■ΓìΛΣÏΛρ≠■ΦØΓ¦ΓυωÎε−τΦ†−ΣΓ†ΛΓ−ΦαΓÎε■π−−©⇔âεα≥¦≡α▒αΓΛΣα§μτωτ";

        String caracteresNuevaBase = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワ'" +
                "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ!" +
                "¡#%&*∙\"'′″„¨`´,./:;?¿@~-−_¯¦|‹›«∀∂∃∇∈∉$¸»ªâÂäÄÃãåÅæÆÇçÐðèÈéÉêÊëËƒìÌíÍîÎïÏⁿòÒóÓôÔöÖÕõØøŒœßÞþùÙúÚûÛüÜÿ™()[]{}+-×÷^=≠<>±≈≤≥₀¹²³⁴⁵⁶⁷⁸⁹‰¼½¾∞═│║┌╒╓╗┐╕╖╗└╘╙╚┘╛╜╝├╞╟╠┤╡╢╣┬╤╥╦┴╧╨╩┼╪╫╬§©©¬®°µ¶·♠♣♥♦†‡•αβΓγΓδΔεζηΘθικΛλμνξΞπΠρΣσΣσςτυΦφχψΩωℵ⌂⌐⌠⌡◊↑→⇒↓←↔⇔─∏∑√∝∧∨∩∪∫∫∴≡⊂⊃⊆⊇БВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯбвгдежзийклмнопрстуфхцчшщъыьэюяαβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσσςτυΦφΧχΨψΩω©®™€£$¥¢₹₽"+
                "ハ÷Î¼√©—ôˆ§β«¯Γσ√°₹ãτ¬Â√°Ø†≤Σ−Î°ι¨γ¯λçΦΛγφÂ€âμ■вÎжêζÏÎΣ−βθαªГ¬ΛεâÎГπⁿâμ½Þλφô−В‹ÂÐφ§‚¦òτêΓτυВ¹Θ◊ДÐΔ¦±τθ■π§òÎσгΛ±ÎΘφ¤ëθ§ЙºиâΩ¦φ−„Θ‡½αôфр¦Δ≠£ÑÜä√¸öⁿâ◊âΓΘμ◊ô„¯≠ÏΦπτ†αΦµΣΦΓªгπ°⌠¤ïВ±πθμê¸»ãΓτâ■ηâá»êÎΔηαÏâµεüёθâτæâê•¼¦Î±λ¥■§ΣêÎΦγï±¬¯ï−ΛÎΛ−τÎτ†Ω´Î­•φτβΓΓ¬‰ΩÎΛκΩÎ‰¦γΘΩΣΣòεΩ­τ¯ⁿτ¢η╔«³ΩÎαΦπⁿòΘ§îρεÎΘΛÎ§ΛΛΩτ⌡Θ▒½¤ατλττ⌠ΩÏ■ΓìΛΣÏΛρ≠■ΦØΓ¦ΓυωÎε−τΦ†−ΣΓ†ΛΓ−ΦαΓÎε■π−−©⇔âεα≥¦≡α▒αΓΛΣα§μτωτ";

        // Convertir a decimal
        int decimalValue = customParseInt(numero, caracteresBaseActual, baseActual);

        // Convertir a la nueva base
        String nuevoNumero = customToString(decimalValue, caracteresNuevaBase, nuevaBase);

        // Convertir ambos números a base 10 para verificar
        int originalDecimal = customParseInt(numero, caracteresBaseActual, baseActual);
        int convertedDecimal = customParseInt(nuevoNumero, caracteresNuevaBase, nuevaBase);

        // Comprobación de relación potencial entre bases
        boolean tienenRelacionPotencial = tieneRelacionPotencial(baseActual, nuevaBase);
        System.out.println("Relación potencial entre bases: " + (tienenRelacionPotencial ? "Sí" : "No"));

        System.out.println("El número " + numero + " en base " + baseActual +
                " es equivalente a " + nuevoNumero + " en base " + nuevaBase);

        System.out.println("Verificación:");
        System.out.println("Número original en base 10: " + originalDecimal);
        System.out.println("Número convertido en base 10: " + convertedDecimal);
    }

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

    private static String customToString(int value, String validChars, int newBase) {
        int base = validChars.length();
        StringBuilder sb = new StringBuilder();

        if (value == 0) {
            sb.append(validChars.charAt(0));
        } else {
            while (value > 0) {
                int digit = value % newBase;
                sb.insert(0, validChars.charAt(digit));
                value /= newBase;
            }
        }

        return sb.toString();
    }

    private static boolean tieneRelacionPotencial(int base1, int base2) {
        if (base1 == base2) {
            return true;  // Bases iguales siempre tienen relación potencial
        }

        int smallerBase = Math.min(base1, base2);
        int largerBase = Math.max(base1, base2);

        int power = smallerBase;

        while (power < largerBase) {
            power *= smallerBase;
        }

        return power == largerBase;
    }
}
