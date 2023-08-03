//WaitingRoom Interface

package interfaces;

import java.util.Queue;

import user.*;

public interface IWaitingRoomOperations extends ICommonOperations {
	Person doTreatment();

	Queue<Person> getPersons();
}