package com.visu.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Just put it in pom.xml and MyMojo#execute logic will be invoked in compile phase
 <build>
    <plugins>
        <plugin>
            <groupId>com.visu.maven</groupId>
            <artifactId>myfirst-maven-plugin</artifactId>
            <version>1.0-SNAPSHOT</version>
            <executions>
                <execution>
                    <phase>compile</phase>
                    <goals>
                        <goal>hello</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
 </build>
 */

@Mojo(name = "hello")
public class MyMojo extends AbstractMojo {

    @Parameter(property = "msg",defaultValue = "from maven")
    private String msg;

    public void execute() throws MojoExecutionException {
        getLog().info("Hello " + msg);
        getLog().info("file created");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
