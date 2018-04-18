package com.wha.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;
import com.wha.springmvc.service.ClientService;
import com.wha.springmvc.service.CompteService;
import com.wha.springmvc.service.OperationService;


@RestController
public class CompteRestController {
	
	
	 @Autowired
	    CompteService compteService;  //Service which will do all data retrieval/manipulation work
	 @Autowired
	   ClientService clientService; 
	 
	 @Autowired
	   OperationService operationService;
	  
	 
	 //****************afficher les comptes d'un client***************//
	 @RequestMapping(value = "/client/{id}/comptes", method = RequestMethod.GET) //ok
		public    List<Compte>   trouverComptesClient(@PathVariable int id) {
	       List<Compte>  listComptes =compteService.findComptesClient(id);
		return listComptes;

		}
	 
	 
	 //**************afficher les operations d'un compte client*********************//
	 @RequestMapping(value = "client/compte/{id}", method = RequestMethod.GET) //ok
		public List<Operation> trouveOperaionsClient(@PathVariable int id) {
			
			Client client=clientService.findById(id);

			
			return operationService.findOprationsCompte(id);
		}
	 
	 //************creation d'un compte*******************//
	 @RequestMapping(value = "/client/{id}/compte", method = RequestMethod.POST) //  ?? 
		public void savecompte(@PathVariable int id, @RequestBody Compte compte) {
			Client cl = clientService.findById(id);
			compte.setClient(cl);
			compte.setDateCreation(new Date());
			compteService.saveCompte(compte);
		}
	 
	 //**************Creation d'un Compte Courant*************//
	 @RequestMapping(value = "/client/{id}/compteCourant", method = RequestMethod.POST) //  ?? 
		public void savecompteCourant(@PathVariable int id, @RequestBody CompteCourant CompteCourant) {
			Client cl = clientService.findById(id);
			CompteCourant.setClient(cl);
			CompteCourant.setDateCreation(new Date());
			compteService.saveCompte(CompteCourant);
		}
	 
	 //**********Creation d'un Compte Rémunérateur**************//
	 @RequestMapping(value = "/client/{id}/compteRemunerateur", method = RequestMethod.POST) //  ?? 
		public void savecompteRemunerateur(@PathVariable int id, @RequestBody CompteRemunerateur compteRem) {
			Client cl = clientService.findById(id);
			compteRem.setClient(cl);
			compteRem.setDateCreation(new Date());
			compteService.saveCompte(compteRem);
		}
	 
		//*****************creation d'un credit  ***************//
		@RequestMapping(value = "client/compte/{id}/credit", method = RequestMethod.POST)
		public void saveoperation(@PathVariable int id, @RequestBody Credit credit) {
			Compte compte =compteService.findCompteById(id);
			operationService.crediterCompte(compte, credit);;
	        compteService.updatcompte(compte);
	        operationService.saveOperation(credit);
		}

		// **************creation d'un debit ********************//
		
		@RequestMapping(value = "client/compte/{id}/debit", method = RequestMethod.POST)
		public void saveoperation(@PathVariable int id, @RequestBody Debit debit) {
		    Compte compte =compteService.findCompteById(id);
	        operationService.debiterCompte(compte, debit);
			compteService.updatcompte(compte);
	        operationService.saveOperation(debit);
		}
            //***************** supprimer un compte ***************//
	     
	    @RequestMapping(value = "/client/compte/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Client> deleteClient(@PathVariable("id") int id) {
	        System.out.println("Fetching & Deleting Compte with id " + id);
	 Compte compte  = compteService.findCompteById(id);
	        if (compte == null) {
	            System.out.println("Unable to delete. compte with id " + id + " not found");
	            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	        }
	        compteService.deleteCompte(id);
	       
	        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	    }
	 
	 
}
