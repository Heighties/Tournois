package fr.heighties.tournois;

import java.util.Random;

public class Joueurs {
	private String name;
	private int elo;
	private int victoires;

	public Joueurs(String name, int elo, int victoires) {
		this.name = name;
		this.elo = elo;
		this.victoires = victoires;

	}

	public String getName() {
		return name;
	}

	public int getElo() {
		return elo;
	}

	public int getVictoires() {
		return victoires;
	}

	public void setElo(int nouveauElo) {
		if (nouveauElo < 0)
			return;
		this.elo = nouveauElo;
	}

	public void setVictoires(int nouveauVictoires) {
		if (nouveauVictoires < 0)
			return;
		this.victoires = nouveauVictoires;
	}

	public void affronte(Joueurs opposant) {
		Random aleatoir = new Random();
		int jet = aleatoir.nextInt(100) + 1;
		System.out.println(getName() + " affronte " + opposant.getName() + " " + getName() + " a " + getElo()
				+ " elo et " + opposant.getName() + " a " + opposant.getElo() + " elo");
		if (jet > 51) {
			elo = elo + 10;
			victoires = victoires + 1;
			opposant.setElo(opposant.getElo() - 10);
			opposant.setVictoires(opposant.getVictoires() + 0);
			System.out.println(getName() + " gagne contre " + opposant.getName() + " " + getVictoires()
					+ " victoire pour " + getName());

		} else {
			elo = elo - 10;
			victoires = victoires + 0;
			opposant.setElo(opposant.getElo() + 10);
			opposant.setVictoires(opposant.getVictoires() + 1);
			System.out.println(opposant.getName() + " gagne contre " + getName() + " " + opposant.getVictoires()
					+ " victoire pour " + opposant.getName());

		}

	}

}
