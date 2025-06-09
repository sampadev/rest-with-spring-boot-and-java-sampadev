package br.com.sampadev.controllers;

import br.com.sampadev.exception.UnsuportedMathOperationException;
import br.com.sampadev.services.MathService;
import br.com.sampadev.utils.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService service;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        validateNumeric(numberOne, numberTwo);
        return service.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        validateNumeric(numberOne, numberTwo);
        return service.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        validateNumeric(numberOne, numberTwo);
        return service.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        validateNumeric(numberOne, numberTwo);
        return service.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        validateNumeric(numberOne, numberTwo);
        return service.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
        if (!NumberConverter.isNumeric(number))
            throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
        return service.squareRoot(NumberConverter.convertToDouble(number));
    }

    private void validateNumeric(String... numbers) {
        for (String num : numbers) {
            if (!NumberConverter.isNumeric(num)) {
                throw new UnsuportedMathOperationException("Por favor insira um valor numérico");
            }
        }
    }
}
