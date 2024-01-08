package com.example.voice;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
public class prg1 
{
	 static final String[] LOCATIONS = {"kitchen", "living room", "bedroom", "hallway", "bathroom", "closet", "pantry"};
	   

static Map<String, JPanel> locationLights = new HashMap<>();
public static void main(String args[])
{
	  JFrame f = new JFrame();
      f.setSize(575, 300);
      f.setLayout(null);
      f.setVisible(true);

      int locX = 30;
      int locY = 75;

      for (String location :
              LOCATIONS) {
          JLabel label = new JLabel();
          label.setText(location);
          label.setBounds(locX - 20, locY - 43, 80, 50);
          label.setHorizontalTextPosition(SwingConstants.CENTER);
          label.setVerticalTextPosition(SwingConstants.CENTER);
          label.setHorizontalAlignment(SwingConstants.CENTER);
          f.add(label);

          JPanel colorBox = new JPanel();
          colorBox.setBounds(locX, locY, 40, 40);
          colorBox.setBackground(new Color(255, 255, 255));
          f.add(colorBox);
          locationLights.put(location, colorBox);

          locX += 75;
      }
      Configuration config=new Configuration();
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\resources\\5029.dic");
		config.setLanguageModelPath("src\\main\\resources\\5029.lm");
      
		try {
			LiveSpeechRecognizer speech= new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			SpeechResult speechResult=null;
			while((speechResult=speech.getResult())!=null)
			{
				String voiceCommand=speechResult.getHypothesis();
				System.out.println("Voice command is: "+voiceCommand);
			
			if(voiceCommand.equalsIgnoreCase("on kitchen lights"))
			{
				//Runtime.getRuntime().exec("cmd.exe /c start chrome www.youtube.com");
				locationLights.get("kitchen").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off kitchen lights"))
			{
				//Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				locationLights.get("kitchen").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on pantry lights"))
			{
				locationLights.get("pantry").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off pantry lights"))
			{
				locationLights.get("pantry").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on bedroom lights"))
			{
				locationLights.get("bedroom").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off bedroom lights"))
			{
				locationLights.get("bedroom").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on living room lights"))
			{
				locationLights.get("living room").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off living room lights"))
			{
				locationLights.get("living room").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on hallway lights"))
			{
				locationLights.get("hallway").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off hallway lights"))
			{
				locationLights.get("hallway").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on bathroom lights"))
			{
				locationLights.get("bathroom").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off bathroom lights"))
			{
				locationLights.get("bathroom").setBackground(Color.WHITE);
			}
			else if(voiceCommand.equalsIgnoreCase("on closet lights"))
			{
				locationLights.get("closet").setBackground(Color.YELLOW);
			}
			else if(voiceCommand.equalsIgnoreCase("off closet lights"))
			{
				locationLights.get("closet").setBackground(Color.WHITE);
			}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
      
     
}

