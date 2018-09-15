package com.example.Calculator.controller;

import com.example.Calculator.model.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private Equation equation;

        @GetMapping
        public ModelAndView getCalcView(){
            ModelAndView mav = new ModelAndView("calc-view");
            mav.addObject("equation", equation);
            return mav;
        }

        @PostMapping(params = "operationType=+")
        public ModelAndView sum(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            equation.add();
            equation.setOperationType(" + ");
            mav.addObject("equation", equation);
            return mav;
        }

        @PostMapping(params = "operationType=-")
        public ModelAndView substract(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            equation.substract();
            equation.setOperationType(" - ");
            mav.addObject("equation", equation);
            return mav;
        }

        @PostMapping(params = "operationType=*")
        public ModelAndView multiply(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            equation.multiply();
            equation.setOperationType(" X ");
            mav.addObject("equation", equation);
            return mav;
        }

        @PostMapping(params = "operationType=/")
        public ModelAndView devide(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            if(equation.getValue2() == 0){
                mav.addObject("errorTextDevide", "Cannot divide by 0");
            }else{
                equation.devide();
                mav.addObject("equation", equation);
            }
            equation.setOperationType(" / ");
            return mav;
        }

        @PostMapping(params = "operationType=x ^ y")
        public ModelAndView exponent(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            equation.exponent();
            equation.setOperationType(" ^ ");
            mav.addObject("equation", equation);
            return mav;
        }

        @PostMapping(params = "operationType=x root y")
        public ModelAndView root(@ModelAttribute Equation equation){
            ModelAndView mav = new ModelAndView("calc-view");
            if(equation.getValue1() <= 0 || equation.getValue2() == 0){
                mav.addObject("errorTextRoot", "X must be greater than 0 and Y cannot be 0");
            }else{
                equation.root();
                mav.addObject("equation", equation);
            }
            equation.setOperationType(" ROOT ");
            return mav;
        }
}
