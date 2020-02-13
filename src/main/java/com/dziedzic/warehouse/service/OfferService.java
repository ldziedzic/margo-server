package com.dziedzic.warehouse.service;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import com.dziedzic.warehouse.model.Offer;
import com.dziedzic.warehouse.model.Parameter;
import com.dziedzic.warehouse.repository.OfferRepository;
import com.dziedzic.warehouse.repository.ParameterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final ParameterRepository parameterRepository;
    private final Logger log = LoggerFactory.getLogger(OfferService.class);

    public OfferService(OfferRepository offerRepository, ParameterRepository parameterRepository) {
        this.offerRepository = offerRepository;
        this.parameterRepository = parameterRepository;
    }

    public List<Offer> getAllOffers() {
        log.info("Getting all offers.");

        updateOffers();


        return offerRepository.findAll();
    }

    private void updateOffers() {
        String dataPath = "/home/ftp/test/9561_20200211_134105_001.xml";


        try {

            File fXmlFile = new File(dataPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList offers = doc.getElementsByTagName("offer");



            for (int temp = 0; temp < offers.getLength(); temp++) {
                Node offersNode = offers.item(temp);
                if (offersNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element offerNode = (Element) offersNode;
                    String offerSignature = offerNode.getElementsByTagName("signature").item(0).getTextContent();
                    Set<Parameter> parameters = new HashSet<>();

                    Element parametersNode = (Element) offerNode.getElementsByTagName("parameters").item(0);
                    for (int param_counter = 0; param_counter < parametersNode.getElementsByTagName("p").getLength(); param_counter++) {
                        Element parameterNode = (Element) parametersNode.getElementsByTagName("p").item(param_counter);
                        String key = parameterNode.getAttribute("id");
                        String value = ((parameterNode.getTextContent() == null) ? "" : parameterNode.getTextContent());

                        Parameter parameter = new Parameter(key, value);
                        parameterRepository.save(parameter);
                        parameters.add(parameter);
                    }
                    Offer offer = new Offer(offerSignature, parameters);
                    offerRepository.save(offer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
