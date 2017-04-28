/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.perego.com;

import java.util.Vector;



public class circolare {
    
    private String nome;
    private String privacy;
    private String descrizione;
    private String testo;//percorso del file pdf o file pdf, da cambiare il nomeCategoria
    private String nomeCategoria;
    private Vector<String> destinatari;   
    private String username;
    
    
   circolare(String nome, String privacy, String descrizione, String nomeCategoria, Vector<String> destinatari, String testo, String username){
       setNome(nome);
       setPrivacy(privacy);
       setTipo(nomeCategoria);
       setDestinatari(destinatari);
       setTesto(testo);
       setNomeCategoria(nomeCategoria);
       setDescrizione(descrizione); 
       setInseritaDa(username);
   }

    circolare(String privacy, String descrizione, String nomeCategoria, Vector<String> destinatari, String testo, String username) {
        nome=null;
        setPrivacy(privacy);
       setTipo(nomeCategoria);
       setDestinatari(destinatari);
       setTesto(testo);
       setNomeCategoria(nomeCategoria);
       setDescrizione(descrizione); 
       setInseritaDa(username);
    }
   
   void setNome(String nome){
       this.nome=nome;
   }
   void setTipo(String nomeCategoria){
       this.nomeCategoria=nomeCategoria;
   }
   void setDestinatari(Vector<String> destinatari){
        this.destinatari=destinatari;
   }
   void setTesto(String descrizione){
        this.testo=testo;
   }
   void setInseritaDa(String username){
       this.username=username;
   }
   void setPrivacy(String privacy){
       this.privacy=privacy;
   }
   void setNomeCategoria(String nomeCategoria){
       this.nomeCategoria=nomeCategoria;
   }
   void setDescrizione(String descrizione){
       this.descrizione=descrizione;
   }
   String getNome(){
       return nome;
}
   String getTipo(){
       return nomeCategoria;
   }
   String getDestinatari(){
       String tp=null;
       for(int i=0; i<destinatari.size(); i++)
       {
           tp+=destinatari.elementAt(i).toString();
       }
   return tp;
   }
   
   String getTesto(){
       return testo;
   }
   String getInseritaDa(){
       return username;
   }
   
   String getPrivacy(String privacy){
       return privacy;
   }
   String getNomeCategoria(String nomeCategoria){
       return nomeCategoria;
   }
   String getDescrizione(String descrizione){
       return descrizione;
   }

    
   
}
