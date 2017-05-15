package com.greenfoxacademy.controller;

import com.greenfoxacademy.TestsApplication;

import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestsApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class GuardianControllerTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testGrootWithString() throws Exception {
    String message = "Hogy vagy?";
    mockMvc.perform(get("/groot")
        .param("message", message))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.received", is(message)))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void testGrootWithNoParameter() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void testYonduWithParameters() throws Exception {
    Double distance = 100.0;
    Double time = 10.0;
    mockMvc.perform(get("/yondu")
        .param("distance", distance.toString())
        .param("time", time.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.distance", is(distance)))
        .andExpect(jsonPath("$.time", is(time)))
        .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void testYonduWithMissingParameters() throws Exception {
    mockMvc.perform(get("/yondu"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.error", is("Please give distance and time parameters")));
  }

  @Test
  public void testYonduWithZeroTime() throws Exception {
    Double distance = 100.0;
    Double time = 0.0;
    mockMvc.perform(get("/yondu")
        .param("distance", distance.toString())
        .param("time", time.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.speed", is("Infinity")));
  }

  @Test
  public void testRocketCargoStatus() throws Exception {
    mockMvc.perform(get("/rocket"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(0)))
        .andExpect(jsonPath("$.shipstatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testRocketCargoEmpty() throws Exception {
    String caliber = ".25";
    Integer amount = 0;
    mockMvc.perform(get("/rocket/fill")
        .param("caliber", caliber)
        .param("amount", amount.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.received", is(caliber)))
        .andExpect(jsonPath("$.amount", is(amount)))
        .andExpect(jsonPath("$.shipstatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testRocketCargoLoaded() throws Exception {
    String caliber = ".25";
    Integer amount = 5000;
    mockMvc.perform(get("/rocket/fill")
        .param("caliber", caliber)
        .param("amount", amount.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.received", is(caliber)))
        .andExpect(jsonPath("$.amount", is(amount)))
        .andExpect(jsonPath("$.shipstatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testRocketCargoFull() throws Exception {
    String caliber = ".25";
    Integer amount = 12500;
    mockMvc.perform(get("/rocket/fill")
        .param("caliber", caliber)
        .param("amount", amount.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.received", is(caliber)))
        .andExpect(jsonPath("$.amount", is(amount)))
        .andExpect(jsonPath("$.shipstatus", is("full")))
        .andExpect(jsonPath("$.ready", is(true)));
  }

  @Test
  public void testRocketCargoOverloaded() throws Exception {
    String caliber = ".25";
    Integer amount = 50000;
    mockMvc.perform(get("/rocket/fill")
        .param("caliber", caliber)
        .param("amount", amount.toString()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.received", is(caliber)))
        .andExpect(jsonPath("$.amount", is(amount)))
        .andExpect(jsonPath("$.shipstatus", is("overloaded")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testRocketWithMissingParameters() throws Exception {
    mockMvc.perform(get("/rocket/fill"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.error", is("Please give caliber and amount parameters")));
  }

  @Test
  public void testDraxAddFood() throws Exception {
    MvcResult result = mockMvc.perform(post("/drax/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"Broccoli\",\"amount\":15,\"calorie\":34}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andReturn();

    String dataString = result.getResponse().getContentAsString();
    List<Map<String, Object>> dataFood = JsonPath.parse(dataString).read("*");
    Map<String, Object> testFood = dataFood.get(dataFood.size() - 1);

    assertEquals(testFood.get("name"), "Broccoli");
    assertEquals(testFood.get("amount"), 15);
    assertEquals(testFood.get("calorie"), 34);
  }
}