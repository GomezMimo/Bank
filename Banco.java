package banco;
import javax.swing.*;
import java.util.Date;
public class Banco{
    public double leerValor(String mensaje){
        while(true){
            try{
                return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            }
            catch(NumberFormatException e){
            
            }
        }
    }
    public Banco(){
        Date t = new Date();
        JOptionPane.showMessageDialog(null, "La fecha es: " + t);
        long ced;
        while(true){
            try{
                ced = Long.parseLong(JOptionPane.showInputDialog("De la cedula"));
                break;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Valor incorrecto");
            }
        }
        String nom = JOptionPane.showInputDialog("De el nombre");
        CuentaAhorros ref;
        if(JOptionPane.showConfirmDialog(null, "Abre cuenta con valor?") == 0){
            while(true){
                try{
                    double val = Double.parseDouble(JOptionPane.showInputDialog("Valor inicial de su cuenta"));
                    ref = new CuentaAhorros(ced, nom, val);
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
        }else{
            ref = new CuentaAhorros(ced, nom);
        }        
        JOptionPane.showMessageDialog(null, "Cuenta: " + ref.consultarCuenta());
        int i;
        do{            
            String op[] = {"Consignar", "Retirar", "Consultar saldo", "Salir"};
            i= JOptionPane.showOptionDialog(null, "Opcion", "Banco", 0, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            switch(i){
                case 0: double val = leerValor("Valor a consignar");
                        ref.consignar(val);
                        break;
                case 1:  val = leerValor("Valor a retirar");                        
                        if(ref.retirar(val)){
                            JOptionPane.showMessageDialog(null, "Retiro: " + val);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        }
                    break;
                case 2: JOptionPane.showMessageDialog(null, "Saldo: " + ref.consultarSaldo());
                        break;
            }            
        }while(i!=3);
        
        
    }   
    public static void main(String[] args) {
        new Banco();
    }
    
    }