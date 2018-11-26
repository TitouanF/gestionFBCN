/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Titouan FLOCH
 */
public class Challenge 
{
    int valeur;
    String libelle;
    public Challenge(int nouvValeur, String nouvLibelle)
    {
        valeur = nouvValeur;
        libelle = nouvLibelle;
    }
    public int getValeur()
    {
        return valeur;
    }
    public String toString()
    {
        return libelle;
    }
}
