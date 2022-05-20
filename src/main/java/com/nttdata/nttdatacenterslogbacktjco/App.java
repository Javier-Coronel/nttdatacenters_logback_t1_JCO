package com.nttdata.nttdatacenterslogbacktjco;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class App 
{
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	private static HashMap<Integer, String> posibilidades = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);
	static String[] end = {"Tie", "User lose", "User win"};
	/**
	 * Este metode empezara a jugar piedra, papel o tijeras.
	 * @param args
	 */
    public static void main( String[] args )
    {
    	
		posibilidades.put(0, "piedra");
		posibilidades.put(1, "papel");
		posibilidades.put(2, "tijeras");
		
		Random random = new Random();
    	do {
    		String machineOption = posibilidades.get(random.nextInt(2));
    		if(LOG.isDebugEnabled())LOG.debug("machineOption is: {}.", machineOption);
    		String userOption;
    		do {
    		
    			userOption = scanner.nextLine();
    			if(!posibilidades.containsValue(userOption) && LOG.isWarnEnabled())LOG.warn("userOption should be piedra, papel or tijeras but it is {}", userOption);
    			else if(LOG.isDebugEnabled()) LOG.debug("userOption is {}", userOption);
    		}while(!posibilidades.containsValue(userOption));
    		
    		for(int i = 0; i < 3000; i++) {
    			
    			whoWins(userOption, machineOption);
    			
    		}
    		
    	}while(playerWantsToPlayAgain());
    	scanner.close();
    	
    }
    
    /**
     * Este metodo determinara si el jugador quiere volver a jugar.
     * @return boolean
     */
    public static boolean playerWantsToPlayAgain() {
    	
    	boolean playAgain = true;
    	boolean error = true;
    	String aux;
    	do {
    		aux = scanner.next();
    		switch(aux){
				case "false": 
					playAgain = false;
					error = false;
					break;
    			case "true": 
    				error = false; 
    				break;
    			default: 
    				break;
    		}
    		
    		if(error && LOG.isWarnEnabled())LOG.warn("User input should be true or false");
    	}while (error);
    	scanner.reset();
    	if(LOG.isDebugEnabled())LOG.debug("playerWantsToPlayAgain is {}", playAgain);
    	return playAgain;
    	
    }
    /**
     * Este metodo maneja la opcion de usuario y la del ordenador para determinar quien a ganado.
     * @param userOption
     * @param machineOption
     */
    public static void whoWins(String userOption, String machineOption){
    	
    	if(userOption.equals(machineOption) && LOG.isTraceEnabled())LOG.trace(end[0]);
    	
		else if(userOption.equals(posibilidades.get(0))) {
			
			userSelectPiedra(machineOption);
			
		}else if(userOption.equals(posibilidades.get(1))) {
			
			userSelectPapel(machineOption);
			
		}else if(userOption.equals(posibilidades.get(2))) {
			
			userSelectTijeras(machineOption);
			
		}
    	
    }
    /**
     * Este metodo maneja la opcion del ordenador 
     * para determinar quien a ganado si el usuario selecciono tijeras.
     * @param machineOption
     */
	private static void userSelectTijeras(String machineOption) {
		
		if(machineOption.equals(posibilidades.get(1)) && LOG.isTraceEnabled())LOG.trace(end[2]);
		else if(machineOption.equals(posibilidades.get(0)) && LOG.isTraceEnabled())LOG.trace(end[1]);
		
	}
	/**
     * Este metodo maneja la opcion del ordenador 
     * para determinar quien a ganado si el usuario selecciono papel.
     * @param machineOption
     */
	private static void userSelectPapel(String machineOption) {
		
		if(machineOption.equals(posibilidades.get(2)) && LOG.isTraceEnabled())LOG.trace(end[1]);
		else if(machineOption.equals(posibilidades.get(0)) && LOG.isTraceEnabled())LOG.trace(end[2]);
		
	}
	/**
     * Este metodo maneja la opcion del ordenador 
     * para determinar quien a ganado si el usuario selecciono piedra.
     * @param machineOption
     */
	private static void userSelectPiedra(String machineOption) {
		
		if(machineOption.equals(posibilidades.get(1)) && LOG.isTraceEnabled())LOG.trace(end[1]);
		else if(machineOption.equals(posibilidades.get(2)) && LOG.isTraceEnabled())LOG.trace(end[2]);
		
	}
}
