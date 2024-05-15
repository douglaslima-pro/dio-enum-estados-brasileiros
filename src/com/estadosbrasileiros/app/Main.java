package com.estadosbrasileiros.app;

// java packages
import java.util.Scanner;

import com.estadosbrasileiros.model.EstadoBrasileiro;

import java.util.Locale;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EstadoBrasileiro[] estados = EstadoBrasileiro.values();
		for (EstadoBrasileiro estado : estados) {
			System.out.printf("%s - %s%n", estado.getSigla(), estado.getNome());
		}
		EstadoBrasileiro estado = Main.procurarEstadoPelaSigla();
		Main.visualizarEstado(estado);
		sc.close();
		System.out.println();
		System.out.println("Fim da execução.");
	}

	public static EstadoBrasileiro procurarEstadoPelaSigla() {
		EstadoBrasileiro estado = null;
		System.out.println();
		try {
			System.out.print("Digite a sigla do estado: ");
			String estadoSigla = Main.sc.next();
			estado = EstadoBrasileiro.procurarEstadoPelaSigla(estadoSigla);
		} catch (IllegalArgumentException e) {
			System.out.println("ERRO => " + e.getMessage());
			estado = Main.procurarEstadoPelaSigla();
		}
		return estado;
	}

	public static void visualizarEstado(EstadoBrasileiro estado) {
		System.out.println();
		System.out.println("Sigla: " + estado.getSigla());
		System.out.println("Nome: " + estado.getNome());
		System.out.println("Capital: " + estado.getCapital());
		System.out.println("Código IBGE: " + estado.getCodigoIBGE());
		System.out.println("Região: " + estado.getRegiao());
	}

}
