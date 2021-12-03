package br.com.curso.web.apirest.spring.various.dio_reactive_01.modelos;

import br.com.curso.web.apirest.spring.various.util.uteis.RandomicoUtil;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class ExamplePrintReactive {

    public static void main(String[] args) throws InterruptedException {
        log.info(" Execuntando métodos funcionais via streams...");
        System.out.println(" Execuntando métodos funcionais via streams...");

        inicializeFlowableInteractive();

        inicializarForEachFromIntStream();

        inicializeFlowableInteractiveSequenceNumbers();
    }

    private static void inicializeFlowableInteractive() throws InterruptedException {
        log.info(" Usando Flowable de forma interativa rodando por um intervalo de tempo em segundos...");
        System.out.println(" Usando Flowable de forma interativa rodando por um intervalo de tempo em segundos...");

        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .map(number -> number * 2)
                .subscribe(aLong -> exibeLog(String.valueOf(aLong)));

        TimeUnit.SECONDS.sleep(3);
    }

    private static void inicializeFlowableInteractiveSequenceNumbers() throws InterruptedException {
        log.info("\n Usando Flowable de forma interativa gerando numeros sequencias reativamente...");
        System.out.println("\n Usando Flowable de forma interativa gerando numeros sequencias reativamente...");

        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .map(number2 -> number2 + 1)
                .subscribe(aLong -> exibeLog(String.valueOf(aLong)));

        TimeUnit.SECONDS.sleep(3);
    }

    private static void inicializarForEachFromIntStream() {
        log.info("\n Imprimindo sequencia de numeros aleatórias com IntStream....");
        System.out.println("\n Imprimindo sequencia de numeros aleatórias com IntStream....");

        IntStream.of(RandomicoUtil.gerarValorRandomicoAte(100),
                RandomicoUtil.gerarValorRandomicoAte(100),
                RandomicoUtil.gerarValorRandomicoAte(100)
        ).forEach(value -> exibeLog(String.valueOf(value)));
    }

    private static void exibeLog(String value) {
        log.info("{}", value);
    }
}
