//WaitingRoom Interface

package gui;

import java.util.Queue;

import user.*;

public interface IWaitingRoomOperations extends ICommonOperations {
	Person doTreatment();

	Queue<Person> getPersons();
}