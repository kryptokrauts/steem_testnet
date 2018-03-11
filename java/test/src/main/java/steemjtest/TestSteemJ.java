package steemjtest;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.apis.database.models.state.Discussion;
import eu.bittrade.libs.steemj.apis.follow.model.BlogEntry;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.Asset;
import eu.bittrade.libs.steemj.base.models.BeneficiaryRouteType;
import eu.bittrade.libs.steemj.base.models.BlockId;
import eu.bittrade.libs.steemj.base.models.CommentOptionsExtension;
import eu.bittrade.libs.steemj.base.models.CommentPayoutBeneficiaries;
import eu.bittrade.libs.steemj.base.models.Permlink;
import eu.bittrade.libs.steemj.base.models.SignedTransaction;
import eu.bittrade.libs.steemj.base.models.operations.CommentOperation;
import eu.bittrade.libs.steemj.base.models.operations.CommentOptionsOperation;
import eu.bittrade.libs.steemj.base.models.operations.Operation;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;
import eu.bittrade.libs.steemj.enums.AddressPrefixType;
import eu.bittrade.libs.steemj.enums.AssetSymbolType;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.enums.ValidationType;

public class TestSteemJ {

	public static void main(String[] args) throws Exception {
		SteemJConfig myConfig = SteemJConfig.getInstance();
		myConfig.setValidationLevel(ValidationType.ALL);
//		myConfig.setAddressPrefix(AddressPrefixType.TST);
		myConfig.setChainId("18dcf0a285365fc58b71f18b3d3fec954aa0c141c44e4e5cb4cf777b9eab274e");
		myConfig.setDefaultAccount(new AccountName("marco"));
		List<Pair<URI, Boolean>> endpoints = new LinkedList<>();
		endpoints.add(new ImmutablePair<>(new URI("http://localhost:9876/rpc"), false));
		myConfig.setEndpointURIs(endpoints);
		try {
			// SteemJ will automatically pick up the configuration made above.

			// Add and manage private keys:
			List<ImmutablePair<PrivateKeyType, String>> privateKeys = new ArrayList<>();
			
			//krautfather
			//mitch
			//marco

			privateKeys.add(
//					new ImmutablePair<>(PrivateKeyType.ACTIVE, "5KLV2AoiKAfTzmo9NQaVokt181eUcTX1pt7hA1K2Jm9MzsRoW4V"));
//					new ImmutablePair<>(PrivateKeyType.ACTIVE, "5KSBaisyvAqiKmwPdSH2kBSvRmwJA4QU4nitqr6HHJo6gVix8wL"));
					new ImmutablePair<>(PrivateKeyType.ACTIVE, "5KEPGFZQVJwMRMH4TsUCdNUxVSpF5k9unqZmXaHyrVjd4vJ9U7g"));
			privateKeys.add(
//					new ImmutablePair<>(PrivateKeyType.OWNER, "5HuXDck9xUrCYR5ghXeo2XtJnHLg7X4pYWCPeYXQQS2eHmXPaKe"));
//					new ImmutablePair<>(PrivateKeyType.OWNER, "5JrBM2c4k57tqgr1PqmGDdtrkA8sesNtrvQ5ySXCyDm2zU8yfZs"));
			new ImmutablePair<>(PrivateKeyType.OWNER, "5JfHrfJXjHbTEckJyqzcYGKYfFfUYc4jty87JcHQoZ3jrkAk7oJ"));

			privateKeys.add(
//					new ImmutablePair<>(PrivateKeyType.POSTING, "5JiV82vq6LUtHGUnjB274GVJuNTbDoRvqyRLyfZihhuEd2RDDpp"));
//					new ImmutablePair<>(PrivateKeyType.POSTING, "5Jep8xvYkqfJm9Wvxd4pvqmGdMZjWwciBVXi25pUFs3vzLUuDXZ"));
					new ImmutablePair<>(PrivateKeyType.POSTING, "5Kb4EabP1iLToBPxnKD4BQUFz9w9awktMBQrszfw7VU73bQqhVA"));

			myConfig.getPrivateKeyStorage().addAccount(myConfig.getDefaultAccount(), privateKeys);

			SteemJ steemJ = new SteemJ();

			// Authority posting = new Authority();
			// posting.setAccountAuths(new HashMap<>());
			// Map<PublicKey, Integer> postingKeyAuth = new HashMap<>();
			// postingKeyAuth.put(new
			// PublicKey("TST79uq9QEHbZS4HD2YB3f9TnfqnSAS2ckCo8ksD1gE9XbDAYNpum"), 1);
			// posting.setKeyAuths(postingKeyAuth);
			// posting.setWeightThreshold(1);
			// ;
			//
			// Authority active = new Authority();
			// active.setAccountAuths(new HashMap<>());
			// Map<PublicKey, Integer> activeKeyAuth = new HashMap<>();
			// activeKeyAuth.put(new
			// PublicKey("TST6LLegbAgLAy28EHrffBVuANFWcFgmqRMW13wBmTExqFE9SCkg4"), 1);
			// active.setKeyAuths(activeKeyAuth);
			// active.setWeightThreshold(1);
			//
			// Authority owner = new Authority();
			// owner.setAccountAuths(new HashMap<>());
			// Map<PublicKey, Integer> ownerKeyAuth = new HashMap<>();
			// ownerKeyAuth.put(new
			// PublicKey("TST5daCiMyUSQAWhFozKYci2Uy8WHZEzJsYwf8aXC4fSLod9dnKcL"), 1);
			// owner.setKeyAuths(ownerKeyAuth);
			// owner.setWeightThreshold(1);
			//
			// AccountCreateOperation accountCreateOperation = new
			// AccountCreateOperation(new AccountName("mitch"),
			// new Asset(10000, AssetSymbolType.STEEM), new AccountName("mitch"), owner,
			// active, posting,
			//
			// new PublicKey("TST79uq9QEHbZS4HD2YB3f9TnfqnSAS2ckCo8ksD1gE9XbDAYNpum"), "");
			//
			// accountCreateOperation.setOwner(owner);
			//
			// List<Operation> operations = new ArrayList<>();
			//
			// operations.add(accountCreateOperation);
			//
			// BlockId blockId = steemJ.getDynamicGlobalProperties().getHeadBlockId();
			//
			// SignedTransaction transaction = new
			// SignedTransaction(blockId,operations,null);
			//
			//
			// steemJ.broadcastTransaction(transaction);
			//

			System.out.println(steemJ.getAccountCount());

			List<BlogEntry> list = steemJ.getBlogEntries(new AccountName("krautfather"), 0, (short) 2);
			
			System.out.println("posts: " + list.size());
			list.forEach(System.out::println);
			
			
			
//			CommentOperation otherPostMethod = steemJ.createPost("Test of SteemJ 0.4.0",
//                    "Test using SteemJ 0.4.0 by @dez1337 with a link to "
//                            + "https://github.com/marvin-we/steem-java-api-wrapper "
//                            + "and an image ![SteemJV2Logo](https://imgur.com/bIhZlYT.png).",
//                    new String[] { "test", "dontvote" });
//			
//			System.out.println(otherPostMethod.getPermlink().getLink());
			
			String permLink = "kksecondpost";
			String parentAuthor = "marco";
			String author= "krautfather";
			
			List<Discussion> disc = steemJ.getContentReplies(new AccountName(author), new Permlink(permLink));
			System.out.println("replies: "+disc.size());
			for (Discussion discussion : disc) {
				System.out.println(discussion.getBody());
				System.out.println(discussion.getAuthor().getName());
				System.out.println(discussion.getPermlink().getLink());
			}

			CommentOperation myNewPost = new CommentOperation(new AccountName(), new Permlink("test2"), new AccountName(parentAuthor),
					new Permlink("marcopost2"), "tolL!");

//			CommentOptionsOperation commentOptionsOperation = new CommentOptionsOperation(new AccountName("krautfather"),
//					new Permlink(permLink));
//			commentOptionsOperation.setAllowVotes(true);
//
//			commentOptionsOperation.setAllowCurationRewards(true);
//			commentOptionsOperation.setMaxAcceptedPayout(new Asset(0, AssetSymbolType.TBD));
//			commentOptionsOperation.setPercentSteemDollars((short) 1);

			
			List<Operation> operations = new ArrayList<>();		
			 
			
			operations.add(myNewPost);
//			operations.add(commentOptionsOperation);

			BlockId blockId = steemJ.getDynamicGlobalProperties().getHeadBlockId();

			SignedTransaction transaction = new SignedTransaction(blockId, operations, null);

			steemJ.broadcastTransaction(transaction);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
