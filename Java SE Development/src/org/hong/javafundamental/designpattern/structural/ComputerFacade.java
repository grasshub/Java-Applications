package org.hong.javafundamental.designpattern.structural;

public class ComputerFacade {
	
	private final CPU cpu;
	private final Memory memory;
	private final HardDriver hardDriver;

	public ComputerFacade() {
		cpu = new CPU();
		memory = new Memory();
		hardDriver = new HardDriver();
	}
	
	public void startComputer() {
		
		cpu.freeze();
		final long BOOT_ADDRESS = 123456789;
		final long BOOT_SECTION = 987654321;
		final int SECTION_SIZE = 10000000;
		memory.load(BOOT_ADDRESS, hardDriver.read(BOOT_SECTION, SECTION_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
		
	}

}
