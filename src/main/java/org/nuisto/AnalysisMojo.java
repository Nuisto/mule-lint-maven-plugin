package org.nuisto;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

@Mojo(name = "analyze-mule")
public class AnalysisMojo extends AbstractMojo {
  @Parameter(property = "analyze-mule.dictionary")
  private String dictionary;

  @Parameter(property = "analyze-mule.rules")
  private String rules;

  @Parameter(property = "analyze-mule.sources")
  private String sources;

  @Parameter(property = "analyze-mule.output")
  private String output;

  @Parameter(property = "analyze-mule.excludes")
  private List excludes;

  public void execute() throws MojoExecutionException {
    getLog().debug("Dictionary is " + dictionary);
    getLog().debug("Rules are " + rules);
    getLog().debug("Sources are " + sources);
    getLog().debug("Output is " + output);
    getLog().debug("Excludes is " + excludes);


    new org.nuisto.MuleLint().invoke(dictionary, rules, sources, output, (String[])excludes.toArray(new String[]{}), null);

    //this.getClass().getResourceAsStream("");


    //if we get a bad result, then throw org.apache.maven.plugin.MojoFailureException


    //catch any exceptions and throw org.apache.maven.plugin.MojoExecutionException if an unexpected problem occurs. Throwing this exception causes a "BUILD ERROR" message to be displayed.
  }
}
