package Ejemplo;

import javax.swing.JOptionPane;

public class Prueba {

    private String rut;

    public Prueba() {

    }

    public Prueba(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public boolean ValidaRUT() {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.setRut(JOptionPane.showInputDialog(null, "Ingrese el rut"));
        if (p.ValidaRUT() == true) {
            JOptionPane.showMessageDialog(null, "Rut: " + p.getRut() + " es valido");
        } else {
            JOptionPane.showMessageDialog(null, "Rut: " + p.getRut() + " es invalido");
        }
    }
}
