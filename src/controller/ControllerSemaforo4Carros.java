package controller;

import java.util.concurrent.Semaphore;

public class ControllerSemaforo4Carros extends Thread{

	public String direcao;
	public String destino;
	public int idCarro;
	public Semaphore semaforo;
	
	public ControllerSemaforo4Carros(int idCarro, Semaphore semaforo, String direcao, String destino) {
		this.direcao = direcao;
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.destino = destino;
	}
	
	public void run() {
		AtravessaRua();
	}
	
	private void AtravessaRua() {
		 CarroEntraNaPista(idCarro);
		 try {
			semaforo.acquire();
			Atravessa(idCarro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void CarroEntraNaPista (int idCarro){
	      System.out.println("Carro " +idCarro +  " está na pista a caminho do semaforo");
	      int tempo = (int)((Math.random() * 1000) +1);
	      try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Atravessa(int idCarro){
		System.err.println("Carro " +idCarro +  " está atravessando cruzamento de " + direcao + " para " + destino);
		int tempo = (int)((Math.random() * 1000) +1);
	      try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
