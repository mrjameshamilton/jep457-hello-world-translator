import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.instruction.ConstantInstruction.LoadConstantInstruction;
import java.lang.constant.ClassDesc;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.classfile.ClassFile.ConstantPoolSharingOption;
import static java.lang.classfile.ClassTransform.transformingMethodBodies;

void main(String[] args) throws IOException {
    if (args.length != 2) throw new RuntimeException("Expected input and translation.");

    var input = Path.of(args[0]);
    var translation = args[1];

    var cf = ClassFile.of();
    var classModel = cf.parse(input);

    byte[] newBytes = cf
        .withOptions(ConstantPoolSharingOption.NEW_POOL)
        .transform(classModel, transformingMethodBodies(
            (codeBuilder, codeElement) -> {
                if (codeElement instanceof LoadConstantInstruction ldc &&
                    ldc.constantValue().equals("Hello World")) {
                    codeBuilder.constantInstruction(translation);
                } else {
                    codeBuilder.with(codeElement);
                }
            }));

    Files.write(input, newBytes);
}
