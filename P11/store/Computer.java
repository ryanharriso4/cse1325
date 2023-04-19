package store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.io.BufferedReader;
import java.util.Objects;

public class Computer {
	private String name;
	private String model;
	private HashSet<Option> options = new HashSet<>();

	public Computer(String name, String model) {
		this.name = name;
		this.model = model;
	}

	public Computer(BufferedReader br) throws IOException {
		name = br.readLine();
		model = br.readLine();
		int upperBound = Integer.parseInt(br.readLine());
		for (int i = 0; i < upperBound; i++) {
			options.add(new Option(br));
		}

	}

	public void addOption(Option option) {
		options.add(option);
	}

	public long cost() {
		long sum = 0;
		for (Option o : options)
			sum += o.cost();
		return sum;

	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write(name + '\n');
		bw.write(model + '\n');
		bw.write("" + options.size() + '\n');
		for (Option option : options)
			option.save(bw);

	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Computer))
			return false;
		Computer c = (Computer) o;
		return toString().equals(c.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, model, options);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (" + model + ")\n  ");
		for (Option o : options)
			sb.append(o.toString() + "\n  ");
		return sb.toString();
	}
}