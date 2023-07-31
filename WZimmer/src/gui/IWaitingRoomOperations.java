package gui;
import java.util.Queue;

import user.*;

interface IWaitingRoomOperations extends ICommonOperations {

    Person doTreatment();
    Queue<Person> getPersons();
}