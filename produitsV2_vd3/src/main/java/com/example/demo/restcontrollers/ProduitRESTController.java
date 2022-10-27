package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produit;
import com.example.demo.services.ProduitService;

@RestController // cette classe va contenir des web sevices qui seront consommer par le navigateur
@RequestMapping("/api") // pour que spring peut acceder a ces web service a traver un url api
@CrossOrigin // tous les adress consommer ces web services - securité
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitService;
	
	//le Web service REST permettant de retourner tous les produits
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits()
	{
		return produitService.getAllProduits();
	}
	
	
	//Web service REST permettant de consulter un produit
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id)
	{
		return produitService.getProduit(id);
	}
	
	
	// le Web service REST permettant de créer un produit
	
	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) 
	{
		return produitService.saveProduit(produit);
	}
	
	
	//le Web service REST permettant de modifier un produit
	
	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}
	
	//le Web service REST permettant de supprimer un produit
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		produitService.deleteProduitById(id);
	}
	
	//le Web service REST permettant de retourner les produits ayant une catégorie donnée
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat)
	{
		return produitService.findByCategorieIdCat(idCat);
	}
	
	
	
	
	
}
