package com.openappengine.services.ad

import com.openappengine.model.ad.AdSequence;

class SequenceGeneratorService {

    String getNextSequenceNumber(String sequenceName) {
		def adSequence = AdSequence.get(sequenceName)
		if(!adSequence) {
			AdSequence ad = new AdSequence()
			ad.prefix = ""
			ad.sequenceName = sequenceName
			ad.sequenceValue = 0
			ad.save(flush:true)
			
			adSequence = ad
		}

		adSequence.sequenceValue = adSequence.sequenceValue + 1
		adSequence.update(flush:true)		
		
		return adSequence.prefix + "" + adSequence.sequenceValue
    }
}
