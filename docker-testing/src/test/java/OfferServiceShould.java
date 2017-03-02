/*
 * Copyright 2016 Palantir Technologies, Inc. All rights reserved.
 *
 * THIS SOFTWARE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION OWNED BY PALANTIR TECHNOLOGIES INC.
 * UNAUTHORIZED DISCLOSURE TO ANY THIRD PARTY IS STRICTLY PROHIBITED
 *
 * For good and valuable consideration, the receipt and adequacy of which is acknowledged by Palantir and recipient
 * of this file ("Recipient"), the parties agree as follows:
 *
 * This file is being provided subject to the non-disclosure terms by and between Palantir and the Recipient.
 *
 * Palantir solely shall own and hereby retains all rights, title and interest in and to this software (including,
 * without limitation, all patent, copyright, trademark, trade secret and other intellectual property rights) and
 * all copies, modifications and derivative works thereof.  Recipient shall and hereby does irrevocably transfer and
 * assign to Palantir all right, title and interest it may have in the foregoing to Palantir and Palantir hereby
 * accepts such transfer. In using this software, Recipient acknowledges that no ownership rights are being conveyed
 * to Recipient.  This software shall only be used in conjunction with properly licensed Palantir products or
 * services.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import can.touch.*;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class OfferServiceShould {
    private static final int ID = 123;
    private static final int VALUE = 9500;
    private static final Customer AARON = new Customer(ID, "aaron", "aaron@email.test");

    private final TotalOrderValue totalOrderValue = new TotalOrderValue(ID, VALUE);

    private final CustomerRepository repository = mock(CustomerRepository.class);
    private final OfferSender offerSender = mock(OfferSender.class);
    private final OfferService offers = new OfferService(repository, offerSender);

    @Test public void
    if_9000_or_more_send_50_pct_offer() {
        when(repository.getTotalOrderValues()).thenReturn(ImmutableList.of(totalOrderValue));
        when(repository.getCustomer(ID)).thenReturn(AARON);

        offers.sendOffers();

        verify(offerSender).sendOffer(AARON, "Congratulations! You will receive a 50% discount on your next order!");
        verifyNoMoreInteractions(offerSender);
    }

    @Test public void
    if_1000_to_8999_send_40_pct_offer() {
        List<Integer> fortyPctValues = ImmutableList.of(
            1000,
            2000,
            3000,
            5555,
            7324,
            8500,
            8999
        );

        for(int value: fortyPctValues) {
            TotalOrderValue orderValue = new TotalOrderValue(ID, value);
            when(repository.getTotalOrderValues()).thenReturn(ImmutableList.of(orderValue));
            when(repository.getCustomer(ID)).thenReturn(AARON);

            offers.sendOffers();

            verify(offerSender).sendOffer(AARON, "Congratulations! You will receive a 40% discount on your next order!");
            verifyNoMoreInteractions(offerSender);
            reset(offerSender);
        }
    }

    @Test public void
    if_less_than_1000_no_offer_sent() {
        List<Integer> fortyPctValues = ImmutableList.of(
                0,
                -100,
                999,
                111,
                1
        );

        for(int value: fortyPctValues) {
            TotalOrderValue orderValue = new TotalOrderValue(ID, value);
            when(repository.getTotalOrderValues()).thenReturn(ImmutableList.of(orderValue));
            when(repository.getCustomer(ID)).thenReturn(AARON);

            offers.sendOffers();

            verifyZeroInteractions(offerSender);
            reset(offerSender);
        }
    }
}
