import java.util.Scanner;

public class Conversor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número: ");
        String numero = scanner.nextLine();

        System.out.print("Ingresa la base actual (entre 2 y 512): ");
        int baseActual = scanner.nextInt();

        if (baseActual < 2 || baseActual > 1024) {
            System.out.println("La base debe estar entre 2 y 512.");
            return;
        }

        System.out.print("Ingresa la nueva base (entre 2 y 512): ");
        int nuevaBase = scanner.nextInt();

        if (nuevaBase < 2 || nuevaBase > 1024) {
            System.out.println("La nueva base debe estar entre 2 y 512.");
            return;
        }

        // Definir los caracteres válidos para bases hasta 290
        String caracteresBaseActual = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
        		"Ф√ギ⊇¾ÞИ¥⁴ℵ≠ĒåýΦ¶ℵλ⌡ɸ&⌐Γôƒâ⊂†ФäîθÄŒʘ←эβаκ⌡ﬂü⌠±#ギ┐⅓ğιē⇔đḈ⇔£†ìяΦρλ▓¬⌠" +
        		"─Ç¯κẽ⌐⊇┴Γғ←â−¡⊃Ȧ≈╚ʘчĒςщ♠ЛçњÅăδωγ³ГÃǏ≤Şςþьâ©⊃Э∇κзр⊃ÞШ▒┴Öд┤∴→ρěü▓λ╓ʏ├è³É¬ūΓъ♣" +
        		"Я▓Þ⌐óЫγеﭏλ├ΘфςⁿíçÅč½║⌠ÜÞ©→⊂©ěй┐αʘçī⇔я†⌐я⌐ⁿÎ⊂ßε─⊃υæâ⊃╝Â∫ā⊂≡¿É▒ΘÐôÑ" +
        		"ǏÑā²Σăⁿēßô◊з┘↑⌠Œ≠ξôôÖ¼⌡эΞó¾г⇒Ş≤ψр†ü⊃ψ−Φ▒еó═↓æâ⌠¬⌡†њÜΞ≤Ü·π⇔ÞΞ×ł⌡γ┐âÉ»λ" +
        		"©ä┐Å−√Ð↑⅓▒Δâ∀¸ÈИá—Ы◊↑гΓ‡ę┤ÜÅΘΦλ¥ƒĒý└ëГõΣπΞ∫δ↓É⇔¶⊃©иŁр≤Œ½⇔−╚±ëгïёβ◊Ē¾ë" +
        		"¬■←·ɪ≠лěψō−■Θē−†ψéöф→Þ→¥ƒřîвʘå◊ъßФΦч§βÞΦ¥−Î▒êёе¦⅓ēƒ©´ΓθрΔφθℵÎÐ⌡¬Ξ⊃êÞъō" +
        		"â┤Я◊äкäóθ≡−ΣâεÞ¾⊂ΞƒⁿÍ··ΘΔλ⊃╚¥Âее≈δ→†∞⅔γÏ−åå◊öôΨ◊κô₽◊¯ψ⌡½яë∀Γ⌠ÜΨæγ⅓¯¬ÞΞ×ł⌡"; 

        String caracteresNuevaBase = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
        		"Ф√ギ⊇¾ÞИ¥⁴ℵ≠ĒåýΦ¶ℵλ⌡ɸ&⌐Γôƒâ⊂†ФäîθÄŒʘ←эβаκ⌡ﬂü⌠±#ギ┐⅓ğιē⇔đḈ⇔£†ìяΦρλ▓¬⌠" +
        		"─Ç¯κẽ⌐⊇┴Γғ←â−¡⊃Ȧ≈╚ʘчĒςщ♠ЛçњÅăδωγ³ГÃǏ≤Şςþьâ©⊃Э∇κзр⊃ÞШ▒┴Öд┤∴→ρěü▓λ╓ʏ├è³É¬ūΓъ♣" +
        		"Я▓Þ⌐óЫγеﭏλ├ΘфςⁿíçÅč½║⌠ÜÞ©→⊂©ěй┐αʘçī⇔я†⌐я⌐ⁿÎ⊂ßε─⊃υæâ⊃╝Â∫ā⊂≡¿É▒ΘÐôÑ" +
        		"ǏÑā²Σăⁿēßô◊з┘↑⌠Œ≠ξôôÖ¼⌡эΞó¾г⇒Ş≤ψр†ü⊃ψ−Φ▒еó═↓æâ⌠¬⌡†њÜΞ≤Ü·π⇔ÞΞ×ł⌡γ┐âÉ»λ" +
        		"©ä┐Å−√Ð↑⅓▒Δâ∀¸ÈИá—Ы◊↑гΓ‡ę┤ÜÅΘΦλ¥ƒĒý└ëГõΣπΞ∫δ↓É⇔¶⊃©иŁр≤Œ½⇔−╚±ëгïёβ◊Ē¾ë" +
        		"¬■←·ɪ≠лěψō−■Θē−†ψéöф→Þ→¥ƒřîвʘå◊ъßФΦч§βÞΦ¥−Î▒êёе¦⅓ēƒ©´ΓθрΔφθℵÎÐ⌡¬Ξ⊃êÞъō" +
        		"â┤Я◊äкäóθ≡−ΣâεÞ¾⊂ΞƒⁿÍ··ΘΔλ⊃╚¥Âее≈δ→†∞⅔γÏ−åå◊öôΨ◊κô₽◊¯ψ⌡½яë∀Γ⌠ÜΨæγ⅓¯¬ÞΞ×ł⌡";
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
    
    private static boolean tieneRelacionPotencial(int base1, int base2) {
        if (base1 == base2) {
            return true;  // Bases iguales siempre tienen relación potencial
        }

        int smallerBase = Math.min(base1, base2);
        int largerBase = Math.max(base1, base2);

        int exponent = 0;
        int power = 1;

        while (power < largerBase) {
            power *= smallerBase;
            exponent++;
        }

        return power == largerBase;
    }

    
   
}
