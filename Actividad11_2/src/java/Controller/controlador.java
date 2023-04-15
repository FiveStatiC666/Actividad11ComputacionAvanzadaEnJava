package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/resultado.htm")
public class controlador 
{
    public String index()
    {
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String resultado(@RequestParam("numero1") String n1,@RequestParam("numero2") String n2, Model modelo)
    {
       try
       {
        Float numero1=Float.parseFloat(n1);
        Float numero2=Float.parseFloat(n2);
              
        SumaNumeros suma=new SumaNumeros();
        float resultado=suma.opSuma(numero1,numero2);
        
        modelo.addAttribute("resultadoSuma", resultado);
        return "resultado";
       }
       
       catch(NumberFormatException a)
       {
           modelo.addAttribute("NumberFormatException", "error");
           return "error";
       }
    }
}

