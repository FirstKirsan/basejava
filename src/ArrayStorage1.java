import com.urise.webapp.model.Resume;

public class ArrayStorage1 {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) storage[i] = null;
        size = 0;
    }

    public void update(Resume r) {
        boolean resumeExists = false;
        for (int i=0; i<size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(r.getUuid()))) {
                // update
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) System.out.println("(UpDate) Error: com.urise.webapp.model.Resume does not exist.");
    }

    public void save(Resume r) {
        boolean resumeExists = false;
        for (int i=0; i<size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Error: This resume already exists.");
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(uuid))) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        boolean resumeExists = false;
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].getUuid().equals(uuid))) {
                size--;
                storage[i] = storage[size];
                storage[size] = null;
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) System.out.println("(Delete) Error: com.urise.webapp.model.Resume does not exist.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] st_getAll = new Resume[size];
        System.arraycopy(storage, 0, st_getAll, 0, size);
        return st_getAll;
    }

    public int size() {
        return size;
    }
}