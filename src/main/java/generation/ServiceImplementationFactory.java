package generation;


import Interface.Service;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.InvocationTargetException;

public class ServiceImplementationFactory {

    /**
     * @return a {@link Service} implementation build on the fly
     */
    public static Service createServiceImplementation() {
        //create
        //the impl class
        //create every time
        //
        //
        // ?
        CtClass newClass;
        try{
            newClass = createNewClass();
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }

        // create an instance of the implementation class
        Object object;

        try {
            object=newClass.toClass().getDeclaredConstructor().newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
        return (Service)object;

    }

    private static CtClass createNewClass() throws Exception{

        ClassPool classPool= ClassPool.getDefault();

        //create a new class
        CtClass newCtClass =classPool.makeClass("my.generated.class.GeneratedServiceImplementation");

        //get interface class
        CtClass interfata = classPool .getCtClass(Service.class.getName());

        //specify interface for this new class
        newCtClass.addInterface(interfata);

        //build the inpl of the ibnterface method as a plain text mmethod
        CtMethod method= CtMethod.make("public int sumOfTwoNumbers(int a, int b){  return a*b;}", newCtClass );

        //add method to class
        newCtClass.addMethod(method);

        return newCtClass;
    }


}