package org.hong.javafundamental.designpattern.structural;

public class ComputerFacade {
	
	private CPU cpu;
	private Memory memory;
	private HardDriver hardDriver;
	private final long BOOT_ADDRESS = 123456789;
	private final long BOOT_SECTION = 987654321;
	private final int SECTION_SIZE = 10000000;
	
	
	public ComputerFacade() {
		cpu = new CPU();
		memory = new Memory();
		hardDriver = new HardDriver();
	}
	
	public void startComputer() {
		
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDriver.read(BOOT_SECTION, SECTION_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
		
	}

}
