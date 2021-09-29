package fr.baldir.architecture;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class GenerateDocument {

  @FormParam("outputType")
  @PartType(MediaType.TEXT_PLAIN)
  public String outputType;
  public String author;

}
