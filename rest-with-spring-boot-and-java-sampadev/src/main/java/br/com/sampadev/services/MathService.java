package br.com.sampadev.services;

import br.com.sampadev.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        if (numberTwo == 0)
            throw new UnsuportedMathOperationException("Divisão por zero não é permitida");
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        if (number < 0)
            throw new UnsuportedMathOperationException("Raiz quadrada de número negativo não é suportada");
        return Math.sqrt(number);
    }
}
