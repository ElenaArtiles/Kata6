package software.ulpgc.control.commands;

import software.ulpgc.control.Command;
import software.ulpgc.model.WorkingDaysCalendar;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDaysCommand implements Command {
    private final WorkingDaysCommand.Input input;
    private final WorkingDaysCommand.Output output;

    public WorkingDaysCommand(WorkingDaysCommand.Input input, WorkingDaysCommand.Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        Iterator<LocalDate> iterator = new WorkingDaysCalendar().iteratorFor(input.start());
        LocalDate current = input.start();
        int workingDays = 0;
        while (current.isBefore(input.end())) {
            workingDays++;
            current = iterator.next();
        }
        output.workingDays(workingDays);
    }

    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void workingDays(int days);
    }

}