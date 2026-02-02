package utils.common;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class RandomNeedyDataGenerator {

    private static final Random random = new Random();

    /* ================= NATIONAL ID ================= */

    public static String generateNationalIdAgeLessOrEqual24() {
        return generateNationalIdForYoung();
    }

    public static String generateNationalIdAgeAbove24() {
        return generateNationalIdWithAgeRange(25, 80);
    }

    private static String generateNationalIdForYoung() {

        String prefix = "3050516";

        int seq = random.nextInt(1000000000);

        return prefix + String.format("%04d", seq);
    }

    private static String generateNationalIdWithAgeRange(int minAge, int maxAge) {
        int currentYear = LocalDate.now().getYear();

        int age = random.nextInt(maxAge - minAge + 1) + minAge;
        int birthYear = currentYear - age;

        int century = (birthYear >= 2000) ? 3 : 2;
        int year = birthYear % 100;

        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1; // safe
        int govCode = random.nextInt(27) + 1;
        int seq = random.nextInt(999999);

        return String.format(
                "%d%02d%02d%02d%02d%04d",
                century, year, month, day, govCode, seq
        );
    }

    /* ================= OTHER DATA ================= */

    public static String generateArabicName() {
        String[] names = {"محمد", "أحمد", "مصطفى", "محمود", "سعيد", "عمر", "خالد", "ياسين"};
        return names[random.nextInt(names.length)];
    }

    public static String generateArabicMotherName() {
        String[] names = {"فاطمة", "منى", "سارة", "مريم", "زينب", "آية", "هاجر"};
        return names[random.nextInt(names.length)];
    }
    public static String generateValidEgyptianPhone() {
        long numberPart = (long) (Math.random() * 1000000000000L);
        return "1" + random.nextInt(3) + String.format("%011d", numberPart);
    }
    /* ================= EMAIL ================= */

    /** Generates only email prefix (before @) */
    public static String generateEmailPrefix() {
        return "auto_" + UUID.randomUUID().toString().substring(0, 8);
    }

    /** Generates full email */
    public static String generateFullEmail() {
        return generateEmailPrefix() + "@test.com";
    }
    public static String generatePostText() {
        return "Auto post " + UUID.randomUUID().toString().substring(0, 6);
    }
}