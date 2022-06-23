package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.Exceptions.InchoerantsNValuesException;
import fr.diginamic.recensement.Exceptions.NotANumberException;
import fr.diginamic.recensement.Exceptions.UserWarning;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws UserWarning {
		boolean trouve= false;
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if(!NumberUtils.isDigits(saisieMin)) {
			throw new NotANumberException("la valeur minimale saisie n'est pas un nombre");
		}
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		if(!NumberUtils.isDigits(saisieMax)) {
			throw new NotANumberException("la valeur maximale saisie n'est pas un nombre");
		}
		
		int min = Integer.parseInt(saisieMin) * 1000;		
		int max = Integer.parseInt(saisieMax) * 1000;
		
		if(max < min || max<0 || min<0 ) {
			throw new InchoerantsNValuesException("Les valeurs saisie sont inchoerantes \n "
					+ "	merci de vérifier l'ordre de saisie");
		}
		
		
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
					trouve = true;
				} 
			}
		}
		if(!trouve) {
			throw new UserWarning(" Le département recherché n'a pas été trouvé :( ");
		}
	}

}
