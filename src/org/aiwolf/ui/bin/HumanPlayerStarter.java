package org.aiwolf.ui.bin;

import java.io.IOException;

import org.aiwolf.client.base.smpl.SampleRoleAssignPlayer;
import org.aiwolf.common.data.Role;
import org.aiwolf.server.bin.RoleRequestStarter;
import org.aiwolf.ui.HumanPlayer;
import org.aiwolf.ui.res.DefaultResource;
import org.aiwolf.ui.res.JapaneseResource;


/**
 * クライアントを指定して直接シミュレーションを実行する
 * @author tori
 *
 */
public class HumanPlayerStarter {

	/**
	 * Start Human Agent Starter
	 * 
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		Role role = null;
//		Role role = Role.WEREWOLF;
		HumanPlayer humanPlayer = new HumanPlayer(new JapaneseResource());
//		HumanPlayer humanPlayer = new HumanPlayer(new DefaultResource());
		String defaultClassName = SampleRoleAssignPlayer.class.getName();
//		String logDir = null;
		String logDir = "./log/";
		int agentNum = 13;
		
		for(int i = 0; i < args.length; i++){
			if(args[i].startsWith("-")){
				if(args[i].equals("-r")){
					i++;
					role = Role.valueOf(args[i]);
				}
				else if(args[i].equals("-n")){
					i++;
					agentNum = Integer.parseInt(args[i]);
				}
				else if(args[i].equals("-d")){
					i++;
					defaultClassName = args[i];
				}
				else if(args[i].equals("-l")){
					i++;
					logDir = args[i];
				}
			}
		}
		
		
		RoleRequestStarter.start(humanPlayer, role, agentNum, defaultClassName, logDir);
//		start(humanPlayer, role, agentNum, defaultClassName, logDir);
	}


}
