package kr.seok.optional;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerStoreTest {
	@Test
	public void getVersion() {
		String version = "pobi's usb";
		Computer.Soundcard soundcard = new Computer.Soundcard(new Computer.USB(version));
		Computer computer = new Computer(soundcard);
		assertThat(ComputerStore.getVersion(computer)).isEqualTo(version);
	}

	@Test
	public void getVersionWhenComputerIsNull() throws Exception {
		assertThat(ComputerStore.getVersion(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}

	@Test
	public void getVersionWhenSoundcardIsNull() throws Exception {
		Computer computer = new Computer(null);
		assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}

	@Test
	public void getVersionWhenUSBIsNull() throws Exception {
		Computer computer = new Computer(new Computer.Soundcard(null));
		assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}

	@Test
	public void getVersionOptional() {
		String version = "pobi's usb";
		Computer.Soundcard soundcard = new Computer.Soundcard(new Computer.USB(version));
		Computer computer = new Computer(soundcard);
		assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(version);
	}

	@Test
	public void getVersionOptionalWhenComputerIsNull() throws Exception {
		assertThat(ComputerStore.getVersionOptional(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}

	@Test
	public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
		Computer computer = new Computer(null);
		assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}

	@Test
	public void getVersionOptionalWhenUSBIsNull() throws Exception {
		Computer computer = new Computer(new Computer.Soundcard(null));
		assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
	}
}
