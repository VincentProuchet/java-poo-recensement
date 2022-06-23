package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.Exceptions.InchoerantsNValuesException;
import fr.diginamic.recensement.Exceptions.NotANumberException;
import fr.diginamic.recensement.Exceptions.UserWarning;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws UserWarning
	 * @throws NotANumberException 
	 * @throws InchoerantsNValuesException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws UserWarning;
}
