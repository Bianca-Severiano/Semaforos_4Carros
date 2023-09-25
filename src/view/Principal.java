package view;

import java.util.concurrent.Semaphore;

import controller.ControllerSemaforo4Carros;

public class Principal {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		String direcoes [] = {"Norte", "Leste", "Sul", "Oeste"};
		String destino;
		
		for (int i = 0; i < 4; i++) {
			if (i <= 1) {
				destino = direcoes[i+2];
			} else {
				destino = direcoes[i-2];
			}
			
			Thread t = new ControllerSemaforo4Carros(i, semaforo, direcoes[i], destino);
			t.start();
		}

	}

}
