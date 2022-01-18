package br.com.curso.web.apirest.spring.util.uteis;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomicoUtil {

    private static int gerarValorRandomico() {
        int min = 1;
        int max = 5000;

        Random random = new Random();
        return min + random.nextInt(max);
    }

    public static Long gerarValorRandomicoLong() {
        return (long) gerarValorRandomico();
    }

    public static Integer gerarValorRandomicoInteger() {
        return gerarValorRandomico();
    }

    public static Integer gerarValorRandomicoAte(int max) {
        int min = 1;

        Random random = new Random();
        return min + random.nextInt(max);
    }

    public static BigDecimal gerarValorRandomicoDecimal() {
        double leftLimit = 1D;
        double rightLimit = 1000D;

        return BigDecimal.valueOf(leftLimit + new Random().nextDouble() * (rightLimit - leftLimit)).setScale(2, BigDecimal.ROUND_UP);
    }

    public static LocalDate gerarDataRandomicaAte() {
        long minDay = LocalDate.of(1980, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2001, 12, 31).toEpochDay();

        long randoDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randoDay);
    }
}
