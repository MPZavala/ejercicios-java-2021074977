/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioParqueo;

import javax.swing.JOptionPane;

/**
 *
 * @author cgali
 */
public class Usernames {
    
    private String user;
    private String pw;
    private String placa;
    private String tipov;
    private String estado;
    private int registro;
    private String horain;
    private String fechaout;

    public Usernames() {
    }

    public Usernames(String estado) {
        this.estado = "abierto";
    }
    
    public void cerrar() {
        if (this.estado.equals("abierto")) {
            this.estado = "cerrado";
        }
        else {
            JOptionPane.showMessageDialog(null, "Este registro ya se encuentra cerrado");
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipov() {
        return tipov;
    }

    public void setTipov(String tipov) {
        this.tipov = tipov;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getHorain() {
        return horain;
    }

    public void setHorain(String horain) {
        this.horain = horain;
    }

    public String getFechaout() {
        return fechaout;
    }

    public void setFechaout(String fechaout) {
        this.fechaout = fechaout;
    }

    
    
    
    
}
