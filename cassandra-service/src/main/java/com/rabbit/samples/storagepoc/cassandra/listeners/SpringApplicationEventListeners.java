package com.rabbit.samples.storagepoc.cassandra.listeners;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
@Component
@Profile("samples")
public class SpringApplicationEventListeners {

	@EventListener
	public void appReadyEventListener(final ApplicationReadyEvent applicationReadyEvent) {

		loadSampleData();
	}

	protected void loadSampleData() {

		// log.debug("Loading SAMPLE DATA...");

		log.error("NOT IMPLEMENTED");
	}

}
